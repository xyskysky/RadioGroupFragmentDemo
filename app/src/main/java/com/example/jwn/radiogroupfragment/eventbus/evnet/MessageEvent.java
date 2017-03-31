package com.example.jwn.radiogroupfragment.eventbus.evnet;

/**
 * 3.创建发送消息类
 */

public class MessageEvent
{
    private String name;

    private String info;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public MessageEvent(String name, String info)
    {
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString()
    {
        return "MessageEvent{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
