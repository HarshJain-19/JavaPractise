package generics;

class G1 {
    public static void main(String[] args) {
        IO<String, String> mockIO = new IO<String, String>() {
            private String channel = "some channel";

            @Override
            public void publish(String data) {
                System.out.println("publishing " + data + " to " + channel);
            }

            @Override
            public String consume() {
                System.out.println("consuming from " + channel);
                return "some useful data consumed";
            }

            @Override
            public String RPCSubmit(String data) {
                return "received " + data + " for now";
            }
        };

        mockIO.consume();
        mockIO.publish("test data");
        System.out.println(mockIO.RPCSubmit("new test data"));
    }
}
