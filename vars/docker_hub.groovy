def call(String ProjectName, String ImageTag, String dockerHubUser)
{
  withCredentials([usernamePassword(credentialsId: "dockerhub", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
                    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
                    sh "docker push ${dockerHubUser}/${ProjectName}:${ImageTag}"
}
