package com.graphql.learn.listener;

import com.graphql.learn.entities.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.PrePersist;



public class AuditTrailListener {
    private static Log log = LogFactory.getLog(AuditTrailListener.class);

    @PrePersist
    private void beforeAnyUpdate(Book book) {
        if (book.getId() == 0) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + book.getId());
        }
    }
}
