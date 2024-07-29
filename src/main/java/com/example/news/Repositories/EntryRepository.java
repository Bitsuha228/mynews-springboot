package com.example.news.Repositories;

import com.example.news.DataAccess.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {
}
