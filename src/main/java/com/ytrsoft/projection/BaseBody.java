package com.ytrsoft.projection;

import java.util.Date;

public interface BaseBody {
    String getId();
    Date getCreated();
    Date getUpdated();
    Boolean getDeleted();
}
