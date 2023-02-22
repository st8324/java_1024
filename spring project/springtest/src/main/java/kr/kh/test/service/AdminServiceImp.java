package kr.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.BoardDAO;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	BoardDAO boardDao;
}
