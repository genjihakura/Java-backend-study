package vn.vti.dtn2501.queue.common;

public interface Producer<T> {
  void fire(T event);
}
