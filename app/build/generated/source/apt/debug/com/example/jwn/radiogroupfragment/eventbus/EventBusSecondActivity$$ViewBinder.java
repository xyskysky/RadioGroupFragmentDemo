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

public class EventBusSecondActivity$$ViewBinder<T extends EventBusSecondActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427529, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131427529, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131427426, "field 'btEventbusSendMain' and method 'onViewClicked'");
    target.btEventbusSendMain = finder.castView(view, 2131427426, "field 'btEventbusSendMain'");
    unbinder.view2131427426 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427427, "field 'btEventbusSendSticky' and method 'onViewClicked'");
    target.btEventbusSendSticky = finder.castView(view, 2131427427, "field 'btEventbusSendSticky'");
    unbinder.view2131427427 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427428, "field 'tvEventbusSendResult'");
    target.tvEventbusSendResult = finder.castView(view, 2131427428, "field 'tvEventbusSendResult'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends EventBusSecondActivity> implements Unbinder {
    private T target;

    View view2131427426;

    View view2131427427;

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
      view2131427426.setOnClickListener(null);
      target.btEventbusSendMain = null;
      view2131427427.setOnClickListener(null);
      target.btEventbusSendSticky = null;
      target.tvEventbusSendResult = null;
    }
  }
}
