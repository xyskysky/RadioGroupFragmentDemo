// Generated code from Butter Knife. Do not modify!
package com.example.jwn.radiogroupfragment.imageloader.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ImageloaderListViewAdapter$ViewHolder$$ViewBinder<T extends ImageloaderListViewAdapter.ViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427510, "field 'iv_image'");
    target.iv_image = finder.castView(view, 2131427510, "field 'iv_image'");
    view = finder.findRequiredView(source, 2131427511, "field 'tv_name'");
    target.tv_name = finder.castView(view, 2131427511, "field 'tv_name'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends ImageloaderListViewAdapter.ViewHolder> implements Unbinder {
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
      target.iv_image = null;
      target.tv_name = null;
    }
  }
}
