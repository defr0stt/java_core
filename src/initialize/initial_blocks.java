package initialize;

public class initial_blocks
{
    private int a;
    private int b;
    private static int c;
    private static int d;
    {               // 3-rd
        a = 1;
        b = 2;
        System.out.println("NON-static initialize block 1");
    }
    static {        // for start static 1-st
        c = 3;
        d = 4;
        System.out.println("Static initialize block 1");
    }
    {               // 4-th
        a = 5;
        b = 6;
        System.out.println("NON-static initialize block 2");
    }
    static {        // then 2-nd
        c = 7;
        d = 8;
        System.out.println("Static initialize block 2");
    }

    public static void main(String[] args) {
        initial_blocks initialBlocks1 = new initial_blocks();
        System.out.println("--------------------");
        initial_blocks initialBlocks2 = new initial_blocks();
    }
}
