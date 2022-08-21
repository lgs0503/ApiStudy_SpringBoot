package com.lgs.file.repositroy;

import com.lgs.file.entitiy.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileInfo, Long>, FileRepositoryCustom {
}