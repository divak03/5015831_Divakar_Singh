package com.bookstore.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.bookstore.dto.BookDTO;
import com.bookstore.entity.Book;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE=Mappers.getMapper(BookMapper.class);
    BookDTO bookToBookDTO(Book book);
    Book bookDTOtoBook(BookDTO bookDTO);
}