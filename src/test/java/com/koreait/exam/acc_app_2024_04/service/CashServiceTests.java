package com.koreait.exam.acc_app_2024_04.service;

import com.koreait.exam.acc_app_2024_04.app.cart.entity.CartItem;
import com.koreait.exam.acc_app_2024_04.app.cart.service.CartService;
import com.koreait.exam.acc_app_2024_04.app.member.entity.Member;
import com.koreait.exam.acc_app_2024_04.app.member.service.MemberService;
import com.koreait.exam.acc_app_2024_04.app.product.entity.Product;
import com.koreait.exam.acc_app_2024_04.app.product.service.ProductService;
import com.koreait.exam.acc_app_2024_04.app.song.service.SongService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class CashServiceTests {

    @Autowired
    private MemberService memberService;



    @Test
    @DisplayName("입금 충전 및 출금")
    void t1() {
        Member member = memberService.findByUsername("user2").get();
        memberService.addCash(member, 5_000, "충전__입금");
        
        assertThat(member.getRestCash()).isEqualTo(5_000);
        memberService.addCash(member, -5_000, "출금__일반");
        assertThat(member.getRestCash()).isEqualTo(0);


    }


}