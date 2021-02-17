package vn.smart.web.domain.event;

@FunctionalInterface
public interface DomainEventHandler<T> {

  void handle(T event);
}
