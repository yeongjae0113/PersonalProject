import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';  // Router만 사용
import ErrorBoundary from './ErrorBoundary';
import Home from './pages/Home';
import Login from './pages/Login';
import Chat from './pages/Chat';
import Calendar from './pages/Calendar';
import MyPage from './pages/Mypage';
import Change from './pages/Change';
import Administrators from './pages/Administrators';
import GitLogo from './pages/GitLogo';

const App = () => {
  return (
    <ErrorBoundary>
      <Router>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<Home />} />
          <Route path="/chat" element={<Chat />} />
          <Route path="/calendar" element={<Calendar />} />
          <Route path="/mypage" element={<MyPage />} />
          <Route path="/change" element={<Change />} />
          <Route path="/gitLogo" element={<GitLogo />} />
          <Route path="/administrators" element={<Administrators />} />
        </Routes>
      </Router>
    </ErrorBoundary>
  );
};

export default App;
