# DebugDnsClient

A simple project to reproduce an issue encountered while using the Vert.X DNS client.

I'm using a public DNS server (taken from this website: https://public-dns.info/nameserver/fr.html)
When I try to use `lookup`, or`lookup4` or even `lookup6` to "google.com", I get the following error:

```
io.vertx.core.VertxException: DNS query timeout for google.com.
	at io.vertx.core.dns.impl.DnsClientImpl$Query.lambda$null$0(DnsClientImpl.java:363)
	at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:276)
	at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:258)
	at io.vertx.core.impl.ContextInternal.lambda$runOnContext$0(ContextInternal.java:56)
	at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:173)
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:166)
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:569)
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base/java.lang.Thread.run(Thread.java:833)
```
If I'm using 8.8.8.8 as DNS server, it works fine with `lookup` but not with `lookup4` or `lookup6`.

Setting Recursion Desired to true or false doesn't change anything.

Updated
