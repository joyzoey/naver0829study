# naver0829study
네이버 클라우드과정 3기 수업


git-bash

1.git init - git과 연동할 폴더 초기화  
2.git remote add origin https://github.com/joyzoey/naver0829study.git - git 원격저장소에 새로 연결  
   - 오류가 나서 새로운 것 저장소랑 연결이 안 될 경우
   - git remote set-url origin https://github.com/joyzoey/naver0829study.git
   (참고로 git에서는 붙여넣기 안됨 오른쪽클릭-paste로 붙여넣기 할 것)

3.git branch - branch  조회  
4.git add. 또는 git add 파일명 : 해당 파일들을 로컬 저장소에 추가  
5.git commit -m 메세지 - 해당 메세지와 함께 위의 파일들을 로컬저장소에 커밋  
6.git push origin 브랜치명 - 원격저장소의 해당 브랜치에 소스 보내기  
   - 반대로 원격 저장소의 수정된 내용을 가져올 경우
   - git pull origin 브랜치명

처음에 한번만 이메일과 유저명 확인  
git config --global user.name "[사용자명]"  
git config --global user.email "[사용자이메일]"  
