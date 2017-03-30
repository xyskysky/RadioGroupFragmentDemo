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

public class FastJsonActivity$$ViewBinder<T extends FastJsonActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131427495, "field 'tvTitle'");
    target.tvTitle = finder.castView(view, 2131427495, "field 'tvTitle'");
    view = finder.findRequiredView(source, 2131427422, "field 'btFastjsonTojavaobject' and method 'OnClick'");
    target.btFastjsonTojavaobject = finder.castView(view, 2131427422, "field 'btFastjsonTojavaobject'");
    unbinder.view2131427422 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427423, "field 'btFastjsonTojavalist' and method 'OnClick'");
    target.btFastjsonTojavalist = finder.castView(view, 2131427423, "field 'btFastjsonTojavalist'");
    unbinder.view2131427423 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427424, "field 'btFastjsonTojsonObject' and method 'OnClick'");
    target.btFastjsonTojsonObject = finder.castView(view, 2131427424, "field 'btFastjsonTojsonObject'");
    unbinder.view2131427424 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427425, "field 'btFastjsonTojsonArray' and method 'OnClick'");
    target.btFastjsonTojsonArray = finder.castView(view, 2131427425, "field 'btFastjsonTojsonArray'");
    unbinder.view2131427425 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnClick(p0);
      }
    });
    view = finder.findRequiredView(source, 2131427426, "field 'tvNativeOrignal'");
    target.tvNativeOrignal = finder.castView(view, 2131427426, "field 'tvNativeOrignal'");
    view = finder.findRequiredView(source, 2131427427, "field 'tvNativeLast'");
    target.tvNativeLast = finder.castView(view, 2131427427, "field 'tvNativeLast'");
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends FastJsonActivity> implements Unbinder {
    private T target;

    View view2131427422;

    View view2131427423;

    View view2131427424;

    View view2131427425;

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
      target.btFastjsonTojavaobject = null;
      view2131427423.setOnClickListener(null);
      target.btFastjsonTojavalist = null;
      view2131427424.setOnClickListener(null);
      target.btFastjsonTojsonObject = null;
      view2131427425.setOnClickListener(null);
      target.btFastjsonTojsonArray = null;
      target.tvNativeOrignal = null;
      target.tvNativeLast = null;
    }
  }
}
