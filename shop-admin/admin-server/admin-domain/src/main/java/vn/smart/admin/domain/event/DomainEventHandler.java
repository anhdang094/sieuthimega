package vn.smart.admin.domain.event;

@FunctionalInterface
public interface DomainEventHandler<T> {

  void handle(T event);
}
