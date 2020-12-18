package com.yu.jetpackbestpractice.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yu.jetpackbestpractice.R;
import com.yu.jetpackbestpractice.databinding.LayoutRefreshViewBinding;
import com.yu.libcommon.view.EmptyView;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author :   yuxibing
 * @date :   2020-12-18
 * Describe : Fragment基类
 */
public abstract class AbsListFragment<T, M extends AbsViewModel<T>> extends Fragment {

    protected LayoutRefreshViewBinding binding;
    protected EmptyView mEmptyView;
    protected SmartRefreshLayout mRefreshLayout;
    protected PagedListAdapter adapter;
    protected RecyclerView mRecyclerView;
    protected ViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LayoutRefreshViewBinding.inflate(inflater, container, false);
        binding.getRoot().setFitsSystemWindows(true);

        mRecyclerView = binding.recyclerView;
        mRefreshLayout = binding.refreshLayout;
        mEmptyView = binding.emptyView;

        mRefreshLayout.setEnableRefresh(true);
        mRefreshLayout.setEnableLoadMore(true);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }
        });

        adapter = getAdapter();
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setItemAnimator(null);

        //默认给列表中的Item 一个 10dp的ItemDecoration
        DividerItemDecoration mDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
        mDecoration.setDrawable(getContext().getDrawable(R.drawable.list_divider));
        mRecyclerView.addItemDecoration(mDecoration);
        genericViewModel();

        return binding.getRoot();
    }

    private void genericViewModel() {
        //利用 子类传递的 泛型参数实例化出absViewModel 对象。
        // TODO: 2020-12-18 断点查看
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] arguments = type.getActualTypeArguments();
        if (arguments.length > 1) {
            Type argument = arguments[1];
            Class modelClaz = ((Class) argument).asSubclass(AbsViewModel.class);
            mViewModel = ViewModelProviders.of(this).get(modelClaz);

            //触发页面初始化数据加载的逻辑


        }

    }

    /**
     * 因为 我们在 onCreateView的时候 创建了 PagedListAdapter
     * 所以，如果arguments 有参数需要传递到Adapter 中，那么需要在getAdapter()方法中取出参数。
     *
     * @return
     */
    public abstract PagedListAdapter getAdapter();
}
