// Generated code from Butter Knife. Do not modify!
package com.example.jwn.radiogroupfragment.imageloader;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ImageloaderGridviewActivity$$ViewBinder<T extends ImageloaderGridviewActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427529, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131427529, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131427448, "field 'gvImageloaderGridview'");
    target.gvImageloaderGridview = finder.castView(view, 2131427448, "field 'gvImageloaderGridview'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ImageloaderGridviewActivity> implements Unbinder {
    private T target;

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
      target.gvImageloaderGridview = null;
    }
  }
}
