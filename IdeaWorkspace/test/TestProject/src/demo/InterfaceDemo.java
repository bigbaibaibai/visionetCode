package demo;

public interface InterfaceDemo {
    enum demo1 implements InterfaceDemo {
        /**
         *
         */
        d1 {
            @Override
            public void invoke() {
                System.out.println("d1");
            }
        }, d2 {
            @Override
            public void invoke() {
                System.out.println("d2");
            }
        }, d3 {
            @Override
            public void invoke() {
                System.out.println("d3");
            }
        }

    }

    /**
     * 执行
     */
    void invoke();
}
