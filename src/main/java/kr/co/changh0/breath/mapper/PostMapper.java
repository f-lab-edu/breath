package kr.co.changh0.breath.mapper;

import kr.co.changh0.breath.dto.PostDto;
import kr.co.changh0.breath.entity.Post;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mappings({
            @Mapping(target = "userSeq", source = "user.userSeq"),
            @Mapping(target = "qnaTypeId", source = "qnaType.qnaTypeId"),
            @Mapping(target = "categoryId", source = "category.categoryId"),
            @Mapping(target = "statusId", source = "status.statusId")
    })
    PostDto postToPostDto(Post post);

    @Mappings({
            @Mapping(target = "user.userSeq", source = "userSeq"),
            @Mapping(target = "qnaType.qnaTypeId", source = "qnaTypeId"),
            @Mapping(target = "category.categoryId", source = "categoryId"),
            @Mapping(target = "status.statusId", source = "statusId")
    })
    Post postDtoToPost(PostDto postDto);


}
