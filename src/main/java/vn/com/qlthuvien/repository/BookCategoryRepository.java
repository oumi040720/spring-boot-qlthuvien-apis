package vn.com.qlthuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.qlthuvien.model.BookCategory;
import vn.com.qlthuvien.model.ClassID.BookCategoryID;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, BookCategoryID> {

}
