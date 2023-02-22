package com.mysite.tojob;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mysite.tojob.question.Question;
import com.mysite.tojob.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//(classes = TojobApplicationTests.class)

@SpringBootTest(classes = TojobApplication.class)
class TojobApplicationTests {

    @Autowired  //Dependency Injection 기능으로 questionRepository 객체를 스프링이 자동으로 생성
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {
        Question q = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q.getId());
    }
}
//db내 컬럼 등록
/*
    Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
                q1.setContent("sbb에 대해서 알고 싶습니다.");
                q1.setCreateDate(LocalDateTime.now());
                this.questionRepository.save(q1);  // 첫번째 질문 저장

                Question q2 = new Question();
                q2.setSubject("스프링부트 모델 질문입니다.");
                q2.setContent("id는 자동으로 생성되나요?");
                q2.setCreateDate(LocalDateTime.now());
                this.questionRepository.save(q2);  // 두번째 질문 저장*/
