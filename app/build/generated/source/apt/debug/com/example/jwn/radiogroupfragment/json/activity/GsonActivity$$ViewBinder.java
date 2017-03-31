// Generated code from Butter Knife. Do not modify!
package com.example.jwn.radiogroupfragment.json.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class GsonActivity$$ViewBinder<T extends GsonActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427529, "field 'mTvTitle'");
    target.mTvTitle = finder.castView(view, 2131427529, "field 'mTvTitle'");
    view = finder.findRequiredView(source, 2131427439, "field 'mBtGsonTojavaobject' and method 'onClick'");
    target.mBtGsonTojavaobject = finder.castView(view, 2131427439, "field 'mBtGsonTojavaobject'");
    unbinder.view2131427439 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427440, "field 'mBtGjsonTojavalist' and method 'onClick'");
    target.mBtGjsonTojavalist = finder.castView(view, 2131427440, "field 'mBtGjsonTojavalist'");
    unbinder.view2131427440 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427441, "field 'mBtGjsonTojsonObject' and method 'onClick'");
    target.mBtGjsonTojsonObject = finder.castView(view, 2131427441, "field 'mBtGjsonTojsonObject'");
    unbinder.view2131427441 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427442, "field 'mBtGjsonTojsonArray' and method 'onClick'");
    target.mBtGjsonTojsonArray = finder.castView(view, 2131427442, "field 'mBtGjsonTojsonArray'");
    unbinder.view2131427442 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427434, "field 'mTvNativeOrignal'");
    target.mTvNativeOrignal = finder.castView(view, 2131427434, "field 'mTvNativeOrignal'");
    view = finder.findRequiredView(source, 2131427435, "field 'mTvNativeLast'");
    target.mTvNativeLast = finder.castView(view, 2131427435, "field 'mTvNativeLast'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends GsonActivity> implements Unbinder {
    private T target;

    View view2131427439;

    View view2131427440;

    View view2131427441;

    View view2131427442;

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
      view2131427439.setOnClickListener(null);
      target.mBtGsonTojavaobject = null;
      view2131427440.setOnClickListener(null);
      target.mBtGjsonTojavalist = null;
      view2131427441.setOnClickListener(null);
      target.mBtGjsonTojsonObject = null;
      view2131427442.setOnClickListener(null);
      target.mBtGjsonTojsonArray = null;
      target.mTvNativeOrignal = null;
      target.mTvNativeLast = null;
    }
  }
}
