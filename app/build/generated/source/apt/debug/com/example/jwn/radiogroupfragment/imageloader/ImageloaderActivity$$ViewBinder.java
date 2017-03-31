// Generated code from Butter Knife. Do not modify!
package com.example.jwn.radiogroupfragment.imageloader;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ImageloaderActivity$$ViewBinder<T extends ImageloaderActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427529, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131427529, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131427444, "field 'btImageloaderListview' and method 'onViewClicked'");
    target.btImageloaderListview = finder.castView(view, 2131427444, "field 'btImageloaderListview'");
    unbinder.view2131427444 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427445, "field 'btImageloaderGridview' and method 'onViewClicked'");
    target.btImageloaderGridview = finder.castView(view, 2131427445, "field 'btImageloaderGridview'");
    unbinder.view2131427445 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427446, "field 'btImageloaderViewpager' and method 'onViewClicked'");
    target.btImageloaderViewpager = finder.castView(view, 2131427446, "field 'btImageloaderViewpager'");
    unbinder.view2131427446 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ImageloaderActivity> implements Unbinder {
    private T target;

    View view2131427444;

    View view2131427445;

    View view2131427446;

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
      view2131427444.setOnClickListener(null);
      target.btImageloaderListview = null;
      view2131427445.setOnClickListener(null);
      target.btImageloaderGridview = null;
      view2131427446.setOnClickListener(null);
      target.btImageloaderViewpager = null;
    }
  }
}
