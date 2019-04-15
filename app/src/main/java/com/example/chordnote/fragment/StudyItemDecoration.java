package com.example.chordnote.fragment;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import static android.support.constraint.Constraints.TAG;

public class StudyItemDecoration extends RecyclerView.ItemDecoration
{
    private Paint mPaint;

    private OnTagListener onTagListener;

    private final int decorationHeight = 50;

    private Paint textPaint;

    public StudyItemDecoration(OnTagListener onTagListener)
    {
        this.onTagListener = onTagListener;
        // 创建画笔
        this.mPaint = new Paint();
        this.textPaint = new Paint();
        // 设置画笔颜色
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#3F51B5"));
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(45);
    }

    // 设置ItemView的内嵌偏移量
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        // 每五个为一个章节（测试）开头的Item上方添加边框
        if (onTagListener.isGroupFirst(position) || position == 0)
        {
            outRect.top = decorationHeight;
        }
    }

    // 子视图上设置绘制范围，并绘制内容
    // 绘制图层再ItemView之下，如果与ItemView区域重叠会被遮挡
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state)
    {
        super.onDraw(c, parent, state);
    }

    // 绘制内容，但与onDraw不同，该绘制再图层的最上层
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state)
    {
        super.onDrawOver(c, parent, state);

        // 获取RecyclerView的Child view的个数
        int childCount = parent.getChildCount();
        // 获取RecyclerView.Adapter中的item个数（只包含改变前的item数）
        int itemCount = parent.getAdapter().getItemCount();
        // 获取屏幕的左右端，定义章节标签的宽
        int left = parent.getLeft() + parent.getPaddingLeft();
        int right = parent.getRight() + parent.getPaddingRight();
        // 获取标题的左端，对其文本
        int viewLeft;
        // 显示当前标签的字符串
        String currentTag = " ";

        // 对每个屏幕中的子项进行遍历，进行相应的绘制
        for (int i = 0; i < childCount; i++)
        {
            View childView = parent.getChildAt(i);
            viewLeft = childView.getLeft();

            // 获取该子View在Adapter中的位置
            int position = parent.getChildAdapterPosition(childView);
            // 判断当前子项是否在当前标签下
            if (TextUtils.equals(currentTag, onTagListener.getGroupName(position)))
            {
                // 如果是当前页，则不做处理
                Log.d(TAG, "onDrawOver: Mark 2");
                continue;
            }
            Log.d(TAG, "onDrawOver: Mark 1");
            currentTag = onTagListener.getGroupName(position);
            int viewBottom = childView.getBottom();
            // Top 是当前子项的顶部，在到达最上方标签前，是子项自己的top，被顶部
            // Tag遮挡时，是顶部标签的高度
            Log.d(TAG, "onDrawOver: Mark 3 ");

            int top = Math.max(decorationHeight, childView.getTop());
            Log.d(TAG, "onDrawOver: Mark 4 ");

            if (position + 1 < itemCount)
            {
                if (!currentTag.equals(onTagListener.getGroupName(position + 1)) &&
                        viewBottom < top)
                {
                    top = viewBottom;
                }
            }

            c.drawRect(left, top - decorationHeight, right, top, mPaint);
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float baseLine = top - (decorationHeight - (fontMetrics.bottom - fontMetrics.top)) / 2
                    - fontMetrics.bottom;
            c.drawText(currentTag, viewLeft, baseLine, textPaint);
        }
    }


    // 使用该Decoration必须实现的接口
    // 该接口提供判断是否为当前标签页的开头和当前标签的名字
    public interface OnTagListener
    {
        String getGroupName(int position);

        boolean isGroupFirst(int position);
    }

}
