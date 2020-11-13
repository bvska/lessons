package com.ifmo.jjd.lesson21;

import java.nio.ByteBuffer;

public class NIOBuffer {
    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(16);
        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16; // разница между position и limit

        // Увеличивает позицию на 4.
        buffer.putInt(100);

        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 8.
        buffer.putDouble(100.25);

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        // Устанавливает лимит на место позиции, сбрасывает позицию в 0 (для чтения из буфера)
        buffer.flip();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        int anInt = buffer.getInt();

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        // Увеличивает позицию на 8.
        double aDouble = buffer.getDouble();

        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        // Сбрасывает позицию в 0 (limit остается на прежнем месте - для повторного чтения)
        buffer.rewind();

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        // Увеличивает позицию на 4.
        assert anInt == buffer.getInt();
        // Увеличивает позицию на 8.
        assert aDouble == buffer.getDouble();

        // Сбрасывает позицию в 0, ставит лимит, равный емкости буфера (для записи в буфер)
        buffer.clear();

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

    }
}