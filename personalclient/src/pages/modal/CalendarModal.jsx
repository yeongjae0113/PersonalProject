import React, { useEffect, useRef, useState } from 'react';
import styles from '../../css/modal/CalendarModal.module.css';

const CalendarModal = ({
  isOpen,
  isEvent,
  onClose,
  title,
  description,
  startDate,
  endDate,
  isNotice,
  selectedEvent,
  setTitle,
  setDescription,
  setStartDate,
  setEndDate,
  setIsNotice,
  handleSave,
  handleUpdate,
  userInfo
}) => {
  const titleRef = useRef(null);

  useEffect(() => {
    if (isOpen && !isEvent) {
      titleRef.current.focus();
    }
  }, [isOpen, isEvent]);

  if (!isOpen) return null;

  const handleTitleChange = (e) => {
    setTitle(e.target.value)
  };

  const handleDescriptionChange = (e) => {
    setDescription(e.target.value)
  };

  const handleStartDateChange = (e) => {
    setStartDate(e.target.value)
  };

  const handleEndDateChange = (e) => {
    setEndDate(e.target.value)
  };

  const user = userInfo?.role;

  return (
    <div className={styles.modalOverlay} onClick={onClose}>
      <div
        className={styles.modalContent}
        onClick={(e) => e.stopPropagation()}
        style={{ position: 'relative' }}
      >
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', width: '100%' }}>
          <h2 className={styles.h2}>{isEvent ? '일정 수정' : '일정 추가'}</h2>
          <button
            className={styles.buttons}
            style={{
              backgroundColor: isNotice ? '#0073CF' : 'white', 
              color: isNotice ? 'white' : '#0073CF',
              border: '1px solid #0073CF', 
              padding: '5px 10px',
              cursor: user === 'ROLE_MASTER' ? 'pointer' : 'not-allowed',
              display: user === 'ROLE_MASTER' ? 'inline-block' : 'none',
              marginLeft: '10px',
            }}
            onClick={() => {
              setIsNotice((prev) => !prev);
              console.log('공지 상태: ', !isNotice);
            }}
          >
            {isNotice ? '공지' : '공지'}
          </button>
        </div>
        <label className={styles.label}>제목</label>
        <input
          type="text"
          placeholder="일정 제목"
          value={isEvent ? selectedEvent?.title || '' : title}
          onChange={handleTitleChange}
          ref={titleRef}
          className={styles.inputField}
        />
        <label className={styles.label}>내용</label>
        <textarea
          placeholder="일정 내용"
          value={isEvent ? selectedEvent?.description || '' : description}
          onChange={handleDescriptionChange}
          className={styles.textareaField}
        />
        <div className={styles.dateContainer}>
          <div className={styles.dateLabel1}>시작일</div>
          <input
            type="date"
            value={isEvent ? selectedEvent?.start || '' : startDate}
            onChange={handleStartDateChange}
            className={styles.inputDate}
          />
          <div className={styles.dateLabel2}>종료일</div>
          <input
            type="date"
            value={isEvent ? selectedEvent?.end || '' : endDate}
            onChange={handleEndDateChange}
            className={styles.inputDate}
          />
        </div>
        <div className={styles.buttonContainer}>
          {!isEvent && (
            <button className={styles.buttons} onClick={handleSave}>
              저장
            </button>
          )}
          {isEvent && (
            <button className={styles.buttons} onClick={handleUpdate}>
              수정
            </button>
          )}
          <button
            className={styles.buttons}
            onClick={() => {
              onClose();
            }}
          >
            닫기
          </button>
        </div>
      </div>
    </div>
  );
};

export default CalendarModal;
