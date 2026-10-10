pipeline {
  agent any
  stages {
    stage('Backend tests') { steps { dir('backend') { sh 'mvn test' } } }
    stage('Frontend build') { steps { dir('frontend') { sh 'npm ci || npm install'; sh 'npm run build' } } }
  }
}
