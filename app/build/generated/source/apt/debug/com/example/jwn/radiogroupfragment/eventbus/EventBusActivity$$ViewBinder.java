// Generated code from Butter Knife. Do not modify!
package com.example.jwn.radiogroupfragment.eventbus;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class EventBusActivity$$ViewBinder<T extends EventBusActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427529, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131427529, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131427422, "field 'btEventbusSend' and method 'onClick'");
    target.btEventbusSend = finder.castView(view, 2131427422, "field 'btEventbusSend'");
    unbinder.view2131427422 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427423, "field 'btEventbusSticky' and method 'onClick'");
    target.btEventbusSticky = finder.castView(view, 2131427423, "field 'btEventbusSticky'");
    unbinder.view2131427423 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427424, "field 'tvEventbusResult'");
    target.tvEventbusResult = finder.castView(view, 2131427424, "field 'tvEventbusResult'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends EventBusActivity> implements Unbinder {
    private T target;

    View view2131427422;

    View view2131427423;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.tvTitle = null;
      view2131427422.setOnClickListener(null);
      target.btEventbusSend = null;
      view2131427423.setOnClickListener(null);
      target.btEventbusSticky = null;
      target.tvEventbusResult = null;
    }
  }
}
