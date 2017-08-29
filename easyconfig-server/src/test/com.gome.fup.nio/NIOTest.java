package com.gome.fup.nio;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by fupeng-ds on 2017/8/29.
 */
public class NIOTest {

    private static final Logger LOGGER = Logger.getLogger(NIOTest.class);

    private Handler handler = new ServerHandler();

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("E://hdfs.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        while (read != -1) {
            System.out.println("Read before:" + read);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
            System.out.println("Read after:" + read);
        }
        file.close();
    }

    @Test
    public void server() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        LOGGER.info("Server: socket server started.");
        while (true) {
            int key = selector.select();
            if (key > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    if (next.isAcceptable()) {
                        LOGGER.info("Server: SelectionKey is Acceptable.");
                        handler.handleAccept(next);
                    }
                    if (next.isReadable()) {
                        LOGGER.info("Server: SelectionKey is Readable.");
                        handler.handleRead(next);
                    }
                    if (next.isWritable()) {
                        LOGGER.info("Server: SelectionKey is Writable.");
                        handler.handleWrite(next);
                    }
                }
            }
        }
    }

    private interface Handler{

        void handleAccept(SelectionKey key) throws IOException;

        void handleRead(SelectionKey key) throws IOException;

        void handleWrite(SelectionKey key) throws IOException;
    }

    private class ServerHandler implements Handler{

        public void handleAccept(SelectionKey key) throws IOException {
            ServerSocketChannel serverchannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverchannel.accept();
            LOGGER.info("Server: accept client socket " + socketChannel);
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(), SelectionKey.OP_READ);
        }

        public void handleRead(SelectionKey key) throws IOException {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            SocketChannel socketChannel = (SocketChannel) key.channel();
            while (true) {
                int read = socketChannel.read(buffer);
                if (read > 0) {
                    LOGGER.info("Server: readBytes = " + read);
                    LOGGER.info("Server: data = " + new String(buffer.array(), 0, read));
                    buffer.flip();
                    socketChannel.write(buffer);
                    break;
                }
            }
            socketChannel.close();
        }

        public void handleWrite(SelectionKey key) throws IOException {
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.flip();
            SocketChannel socketChannel = (SocketChannel) key.channel();
            socketChannel.write(buffer);
            if (buffer.hasRemaining()) {
                key.interestOps(SelectionKey.OP_READ);
            }
            buffer.compact();
        }
    }

    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.write(ByteBuffer.wrap("test".getBytes()));
        while (true) {
            buffer.clear();
            int read = socketChannel.read(buffer);
            if (read > 0) {
                buffer.flip();
                LOGGER.info("Client: readBytes = " + read);
                LOGGER.info("Client: data = " + new String(buffer.array(), 0, read));
                socketChannel.close();
                break;
            }
        }
    }
}
