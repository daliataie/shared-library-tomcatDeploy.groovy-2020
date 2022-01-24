def call(credId,tomcatIp,tomcatUser){
  sshagent([credId]) {
    // copy war file to tomcat server
    sh """
        scp -o StrictHostKeyChecking=no target/myweb*.war ${tomcatUser}@${tomcatIp}:/opt/tomcat8/webapps/myweb.war
        ssh ${tomcatUser}@${tomcatIp} /opt/tomcat8/bin/shutdown.sh
        ssh ${tomcatUser}@${tomcatIp} /opt/tomcat8/bin/startup.sh
    """
  }
}
