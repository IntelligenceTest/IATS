package com.autostreets.biz.auction.pagination;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Pagination1<T> extends Serializable {
    boolean isFirstPage();

    boolean isLastPage();

    boolean hasNextPage();

    boolean hasPreviousPage();

    int getFirstPageNumber();

    int getLastPageNumber();

    List<T> getThisPageElements();

    int getTotalNumberOfElements();

    int getThisPageFirstElementNumber();

    int getThisPageLastElementNumber();

    int getNextPageNumber();

    int getPreviousPageNumber();

    int getPageSize();

    int getPageNumber();

    Map<String, Object> getModel();
}
