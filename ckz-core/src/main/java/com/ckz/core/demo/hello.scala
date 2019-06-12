package com.ckz.core.utils

object Hello {
  def sayHello(x: String): Unit = {
    println("hello," + x);
  }

  def main(args: Array[String]):Unit = {
    BaseContextHandler.setUserID("sdsd")
    val value = BaseContextHandler.get("currentUserId")

    println("com.live.channel.manager.utils.Hello World!"+value)
  }
}

