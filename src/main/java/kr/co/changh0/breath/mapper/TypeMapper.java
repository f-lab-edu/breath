package kr.co.changh0.breath.mapper;

import kr.co.changh0.breath.dto.PostTypeDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMapper {

    Integer getPostTypeId(String type);

    List<PostTypeDto> getPostTypeList(boolean adminCheck);

}
