
package com.smartware.container;

import java.text.SimpleDateFormat;
import java.util.Locale;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.VisibleForTesting;

public class ScheduleItem implements Parcelable {

	/**
	 * ST : Schedule Type
	 * **/
	public static final int 		ST_NONE = -1;					/** 없음 **/
	public static final int 		ST_ATTENDANCE = 0;	/** 출석 **/
	public static final int 		ST_COURSE = 1;				/** 수강 **/
	public static final int 		ST_TODO = 2;					/** 할일 **/
	public static final int 		ST_ASSIGNMENT = 3;		/** 과제 **/

	/**
	 * CTG : Category
	 * **/
	public static final int		CTG_NONE = -1;				/** 없음 **/
	public static final int		CTG_PLAN = 0;				/** plan **/
	public static final int		CTG_DO = 1;					/** do **/
//	public static final int		CTG_SEE = 2;					/** see **/

	/**
	 * WANT : Wrong Answer Note Type
	 * **/
	public static final int		WANT_NONE = 0;				/** 없음 **/
	public static final int		WANT_ENABLE = 1;				/** 있음 **/

	/**
	 * CT : Cell Type
	 * **/
	public static final int		CT_SECTION_PLAN = 0;	/** 없음 **/
	public static final int		CT_SECTION_DO = 1;		/** 없음 **/
	public static final int		CT_ITEM = 2;					/** 없음 **/

	/**
	 * DOW : Day Of Week (요일)
	 * **/
	public static final int		DOW_SUN = 0;				/** 일요일 **/
	public static final int		DOW_MON = 1;				/** 월요일 **/
	public static final int		DOW_TUE = 2;				/** 화요일 **/
	public static final int		DOW_WED = 3;				/** 수요일 **/
	public static final int		DOW_THR = 4;				/** 목요일 **/
	public static final int		DOW_FRI = 5;					/** 금요일 **/
	public static final int		DOW_SAT = 6;					/** 토요일 **/

	public static final String  	TEST_VIEW = "[문제 풀이]";
	public static final String  	OXNOTE_VIEW = "[오답 노트]";

	private int						mIdx;
	private int						mType;
	private int						mCategory;
	private long					mDate;
	private int						mDayOfWeek;
	private String					mTitle;
	private int						mWrongAnswerNoteType;
	private int						mCellType;
	private String                  mFolderID;
	private String                  mFrom;
	private String                  mWorkbookName;

	public ScheduleItem() {
		mIdx = 0;
		mType = ST_NONE;
		mCategory = CTG_NONE;
		mDate = 0L;
		mDayOfWeek = DOW_SUN;
		mTitle = "";
		mWrongAnswerNoteType = WANT_NONE;
		mCellType = CT_ITEM;
		mFolderID = "";
		mFrom = "";
		mWorkbookName= "";
	}

	public ScheduleItem(int idx, int type, int category, long date, int dayOdWeek, String title,
						int wrongAnswerNoteType, int cellType, String folderID, String from, String workbookName) {
		mIdx = idx;
		mType = type;
		mCategory = category;
		mDate = date;
		mDayOfWeek = dayOdWeek;
		mTitle = title;
		mWrongAnswerNoteType = wrongAnswerNoteType;
		mCellType = cellType;
		mFolderID = folderID;
		mFrom = from;
		mWorkbookName = workbookName;
	}

	public ScheduleItem(ScheduleItem item) {
		mIdx = item.getIdx();
		mType = item.getType();
		mCategory = item.getCategory();
		mDate = item.getDate();
		mDayOfWeek = item.getDayOfWeek();
		mTitle = item.getTitle();
		mWrongAnswerNoteType = item.getWrongAnswerNoteType();
		mCellType = item.getCellType();
		mFolderID = item.getFolderID();
		mFrom = item.getFrom();
		mWorkbookName = item.getWorkbookName();
	}

	public ScheduleItem(Parcel source) {
		mIdx = source.readInt();
		mType = source.readInt();
		mCategory = source.readInt();
		mDate = source.readLong();
		mDayOfWeek = source.readInt();
		mTitle = source.readString();
		mWrongAnswerNoteType = source.readInt();
		mCellType = source.readInt();
		mFolderID = source.readString();
		mFrom = source.readString();
		mWorkbookName = source.readString();
	}

	public static final Parcelable.Creator<ScheduleItem> CREATOR = new Parcelable.Creator<ScheduleItem>() {

		@Override
		public ScheduleItem createFromParcel(Parcel source) {
			return new ScheduleItem(source);
		}

		@Override
		public ScheduleItem[] newArray(int size) {
			return new ScheduleItem[size];
		}

	};

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(mIdx);
		dest.writeInt(mType);
		dest.writeInt(mCategory);
		dest.writeLong(mDate);
		dest.writeInt(mDayOfWeek);
		dest.writeString(mTitle);
		dest.writeInt(mWrongAnswerNoteType);
		dest.writeInt(mCellType);
		dest.writeString(mFolderID);
		dest.writeString(mFrom);
		dest.writeString(mWorkbookName);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public String toString() {
		return String.format(Locale.getDefault(), "[ScheduleItem]\n"
						+ "idx : %d\n"
						+ "type : %d\n"
						+ "category : %d\n"
						+ "date : %s\n"
						+ "day of week : %d\n"
						+ "title : %s\n"
						+ "wrongAnswerNoteType : %d\n"
						+ "mCellType : %d\n"
						+ "mFolderID : %s\n"
						+ "mFrom : %s\n"
						+ "mWorkbookName : %s\n",
				mIdx, mType, mCategory, getDateString(), mDayOfWeek, mTitle, mWrongAnswerNoteType, mCellType, mFolderID, mFrom, mWorkbookName ) ;
	}

	public void setIdx(int idx) {
		mIdx = idx;
	}

	public int getIdx() {
		return mIdx;
	}

	public int getType() {
		return mType;
	}

	public void setType(int type) {
		mType = type;
	}

	public void setCategory(int category) {
		mCategory = category;
	}

	public int getCategory() {
		return mCategory;
	}

	public void setDate(long date) {
		mDate = date;
	}

	public long getDate() {
		return mDate;
	}

	public String getFolderID() {
		return mFolderID;
	}

	public void setFolderID(String mFolderID) {
		this.mFolderID = mFolderID;
	}

	public String getFrom() {
		return mFrom;
	}

	public void setFrom(String mFrom) {
		this.mFrom = mFrom;
	}

	public String getWorkbookName() {
		return mWorkbookName;
	}

	public void setWorkbookName(String mWorkbookName) {
		this.mWorkbookName = mWorkbookName;
	}

	public String getDateString(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
		return formatter.format(mDate);
	}

	public String getDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
		return formatter.format(mDate);
	}

	public void setDayOfWeek(int dayOfWeek) {
		mDayOfWeek = dayOfWeek;
	}

	public int getDayOfWeek() {
		return mDayOfWeek;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setWrongAnswerNoteType(int wrongAnswerType) {
		mWrongAnswerNoteType = wrongAnswerType;
	}

	public int getWrongAnswerNoteType() {
		return mWrongAnswerNoteType;
	}

	public void setCellType(int cellType) {
		mCellType = cellType;
	}

	public int getCellType() {
		return mCellType;
	}
}
























