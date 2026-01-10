package UMC_9th.AhanOn.domain.chapter.service;

import UMC_9th.AhanOn.domain.book.entity.Book;
import UMC_9th.AhanOn.domain.chapter.code.ChapterErrorCode;
import UMC_9th.AhanOn.domain.chapter.dto.ChapterReqDTO;
import UMC_9th.AhanOn.domain.chapter.entity.Chapter;
import UMC_9th.AhanOn.domain.chapter.exception.ChapterException;
import UMC_9th.AhanOn.domain.chapter.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ChapterService {

    private final ChapterRepository chapterRepository;

    public Long createChapter (ChapterReqDTO.CreateChapterDTO dto){
        Chapter chapter = Chapter.builder()
                .book(new Book())
                .title(dto.getTitle())
                .content(dto.getContent())
                .comments(null)
                .build();

        Chapter saved = chapterRepository.save(chapter);
        return saved.getId();
    }

    public Boolean deleteChapter(Long chapterId){
        Chapter chapter = chapterRepository.findById(chapterId).orElseThrow(() -> new ChapterException(ChapterErrorCode.WRONG_CHAPTER));
        chapterRepository.delete(chapter);
        return true;
    }

    public Boolean updateChapter(Long chapterId){
        Chapter chapter = chapterRepository.findById(chapterId).orElseThrow(() -> new ChapterException(ChapterErrorCode.WRONG_CHAPTER));

        chapter.

        return true;
    }
}
