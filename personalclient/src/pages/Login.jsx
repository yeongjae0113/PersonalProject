import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styles from '../css/Login.module.css';
import axios from 'axios';
import Footer from './Footer';
import Header from './Header';
import Logo from '../img/logo.png';

const Login = () => {
    const navigate = useNavigate();
    const [userId, setUserId] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.get('http://localhost:8088/user/login', {
                params: { userId, password }
            });

            // 서버에서 받은 데이터에서 필요한 값만 추출
            const userInfo = {
                id: response.data.id,
                userId: response.data.userId,
                username: response.data.username,
                password: response.data.password,
                gender: response.data.gender,
                age: response.data.age,
                phoneNumber: response.data.phoneNumber,
                position: response.data.position,
                department: response.data.department ? response.data.department.department : '부서 정보 없음', // 중복된 department 처리
                role: response.data.role
            };

            console.log('로그인 성공', response.data);
            alert('로그인 성공');
            
            localStorage.setItem('userInfo', JSON.stringify(userInfo));
            localStorage.setItem('isLogin', 'true');
            navigate('/home');
        } catch (error) {
            console.error('로그인 실패', error);
            alert('로그인 실패했습니다. 다시 시도해주세요.');
        }
    }

    return (
        <>
        <Header />
            <div className={styles.container}>
                <form className={styles['login-container']} onSubmit={handleLogin}>
                    <div>
                        {/* <div className={styles.logoDiv}><img className={styles.logo} src={Logo} alt='로고 오류류'></img></div> */}
                    </div>
                    <h1 className={styles.login}>Login</h1>
                    <div>
                        <label className={styles.label}>아이디</label>
                        <input className={styles.input}
                            id='userId' 
                            type='text'
                            placeholder='아이디를 입력하세요'
                            value={userId}
                            onChange={(e) => setUserId(e.target.value)} />
                    </div>
                    <div>
                        <label className={styles.label}>비밀번호</label>
                        <input className={styles.input}
                            id='password'
                            type='password'
                            placeholder='비밀번호를 입력하세요'
                            value={password}
                            onChange={(e) => setPassword(e.target.value)} />
                    </div>
                    <div className={styles.buttonDiv}>
                        <button className={styles.buttons} type='submit'>로그인</button>
                    </div>
                </form>
            </div>
             <Footer/>
        </>
    );
};

export default Login;
