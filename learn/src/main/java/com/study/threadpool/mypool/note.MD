> 自己模拟的线程池  

```java
volatile int status=0;//标识---是否有线程在同步块-----是否有线程上锁成功
void lock(){
	while(!compareAndSet(0,1)){
	}
	//lock
}
void unlock(){
	status=0;
}
boolean compareAndSet(int except,int newValue){
	//cas操作,修改status成功则返回true
}
```