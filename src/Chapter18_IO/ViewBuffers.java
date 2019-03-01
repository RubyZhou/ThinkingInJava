package Chapter18_IO;


import java.nio.*;

import static Fourth_util.Print.print;
import static Fourth_util.Print.printnb;

/**
 * 以不同视图读出同一 ByteBuffer 的结果
 */
public class ViewBuffers {
    public static void main(String[] args) {

        printnb("\n Byte Buffer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n    ");
        // 写数据
        ByteBuffer bb =
                ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        // 读数据
        bb.rewind();
        while (bb.hasRemaining())
            printnb(bb.position() + " -> " + bb.get() + ", ");


        printnb("\n Char Buffer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n    ");
        CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
        while (cb.hasRemaining())
            printnb(cb.position() + " -> " + cb.get() + ", ");


        printnb("\n Float Buffer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n    ");
        FloatBuffer fb =
                ((ByteBuffer) bb.rewind()).asFloatBuffer();

        while (fb.hasRemaining())
            printnb(fb.position() + " -> " + fb.get() + ", ");


        printnb("\n Int Buffer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n    ");
        IntBuffer ib =
                ((ByteBuffer) bb.rewind()).asIntBuffer();

        while (ib.hasRemaining())
            printnb(ib.position() + " -> " + ib.get() + ", ");


        printnb("\n Long Buffer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n    ");
        LongBuffer lb =
                ((ByteBuffer) bb.rewind()).asLongBuffer();

        while (lb.hasRemaining())
            printnb(lb.position() + " -> " + lb.get() + ", ");


        printnb("\n Short Buffer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n    ");
        ShortBuffer sb =
                ((ByteBuffer) bb.rewind()).asShortBuffer();

        while (sb.hasRemaining())
            printnb(sb.position() + " -> " + sb.get() + ", ");


        printnb("\n Double Buffer >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n    ");
        DoubleBuffer db =
                ((ByteBuffer) bb.rewind()).asDoubleBuffer();

        while (db.hasRemaining())
            printnb(db.position() + " -> " + db.get() + ", ");
    }
}
