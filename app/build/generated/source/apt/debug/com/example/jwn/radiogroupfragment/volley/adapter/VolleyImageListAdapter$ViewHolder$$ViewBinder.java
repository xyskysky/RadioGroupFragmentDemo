// Generated code from Butter Knife. Do not modify!
package com.example.jwn.radiogroupfragment.volley.adapter;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class VolleyImageListAdapter$ViewHolder$$ViewBinder<T extends VolleyImageListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427475, "field 'iv_icon'");
    target.iv_icon = finder.castView(view, 2131427475, "field 'iv_icon'");
    view = finder.findRequiredView(source, 2131427527, "field 'tv_name'");
    target.tv_name = finder.castView(view, 2131427527, "field 'tv_name'");
    view = finder.findRequiredView(source, 2131427528, "field 'tv_desc'");
    target.tv_desc = finder.castView(view, 2131427528, "field 'tv_desc'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends VolleyImageListAdapter.ViewHolder> implements Unbinder {
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
      target.iv_icon = null;
      target.tv_name = null;
      target.tv_desc = null;
    }
  }
}
