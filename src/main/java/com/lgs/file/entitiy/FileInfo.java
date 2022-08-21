package com.lgs.file.entitiy;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="FileInfo")
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    private String originFileName;
    private String fileName;
    private String fileExtension;
    private String filePath;

    private long fileSize;

    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();

    @Builder
    public FileInfo(String originFileName,
                    String fileName,
                    String filePath,
                    String fileExtension,
                    long fileSize) {
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileExtension = fileExtension;
        this.fileSize = fileSize;
    }
}