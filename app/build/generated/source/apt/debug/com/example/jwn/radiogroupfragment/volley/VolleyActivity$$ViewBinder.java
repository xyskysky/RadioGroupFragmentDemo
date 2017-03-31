// Generated code from Butter Knife. Do not modify!
package com.example.jwn.radiogroupfragment.volley;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class VolleyActivity$$ViewBinder<T extends VolleyActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427529, "field 'mTvTitle'");
    target.mTvTitle = finder.castView(view, 2131427529, "field 'mTvTitle'");
    view = finder.findRequiredView(source, 2131427480, "field 'mBtVolleyGet' and method 'onClick'");
    target.mBtVolleyGet = finder.castView(view, 2131427480, "field 'mBtVolleyGet'");
    unbinder.view2131427480 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427481, "field 'mBtVolleyPost' and method 'onClick'");
    target.mBtVolleyPost = finder.castView(view, 2131427481, "field 'mBtVolleyPost'");
    unbinder.view2131427481 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427482, "field 'mBtVolleyGetjson' and method 'onClick'");
    target.mBtVolleyGetjson = finder.castView(view, 2131427482, "field 'mBtVolleyGetjson'");
    unbinder.view2131427482 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427483, "field 'mBtVolleyImagerequest' and method 'onClick'");
    target.mBtVolleyImagerequest = finder.castView(view, 2131427483, "field 'mBtVolleyImagerequest'");
    unbinder.view2131427483 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427484, "field 'mBtVolleyImageloader' and method 'onClick'");
    target.mBtVolleyImageloader = finder.castView(view, 2131427484, "field 'mBtVolleyImageloader'");
    unbinder.view2131427484 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427485, "field 'mBtVolleyNetworkimageview' and method 'onClick'");
    target.mBtVolleyNetworkimageview = finder.castView(view, 2131427485, "field 'mBtVolleyNetworkimageview'");
    unbinder.view2131427485 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427486, "field 'mBtVilleyListImage' and method 'onClick'");
    target.mBtVilleyListImage = finder.castView(view, 2131427486, "field 'mBtVilleyListImage'");
    unbinder.view2131427486 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427487, "field 'mIvVolleyResult'");
    target.mIvVolleyResult = finder.castView(view, 2131427487, "field 'mIvVolleyResult'");
    view = finder.findRequiredView(source, 2131427488, "field 'mIvVolleyNetworkimagview'");
    target.mIvVolleyNetworkimagview = finder.castView(view, 2131427488, "field 'mIvVolleyNetworkimagview'");
    view = finder.findRequiredView(source, 2131427489, "field 'mTvVolleyResult'");
    target.mTvVolleyResult = finder.castView(view, 2131427489, "field 'mTvVolleyResult'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends VolleyActivity> implements Unbinder {
    private T target;

    View view2131427480;

    View view2131427481;

    View view2131427482;

    View view2131427483;

    View view2131427484;

    View view2131427485;

    View view2131427486;

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
      target.mTvTitle = null;
      view2131427480.setOnClickListener(null);
      target.mBtVolleyGet = null;
      view2131427481.setOnClickListener(null);
      target.mBtVolleyPost = null;
      view2131427482.setOnClickListener(null);
      target.mBtVolleyGetjson = null;
      view2131427483.setOnClickListener(null);
      target.mBtVolleyImagerequest = null;
      view2131427484.setOnClickListener(null);
      target.mBtVolleyImageloader = null;
      view2131427485.setOnClickListener(null);
      target.mBtVolleyNetworkimageview = null;
      view2131427486.setOnClickListener(null);
      target.mBtVilleyListImage = null;
      target.mIvVolleyResult = null;
      target.mIvVolleyNetworkimagview = null;
      target.mTvVolleyResult = null;
    }
  }
}
