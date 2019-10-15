package com.shardingjdbc.repository;

import com.shardingjdbc.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wtq
 * @date 2019/10/14 - 10:41
 */
public interface DictionaryRepository extends JpaRepository<Dictionary,Long>{
}
