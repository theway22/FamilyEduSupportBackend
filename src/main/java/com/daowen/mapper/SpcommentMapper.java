package com.daowen.mapper;
import com.daowen.ssm.simplecrud.SimpleMapper;
import com.daowen.entity.Spcomment;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SpcommentMapper  extends SimpleMapper<Spcomment> {

    List<Spcomment>   getEntity();

}