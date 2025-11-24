package generics;

public interface IO<IncomingType, OutgoingType> {
    void publish(OutgoingType data);
    IncomingType consume();
    IncomingType RPCSubmit(OutgoingType data);
}
