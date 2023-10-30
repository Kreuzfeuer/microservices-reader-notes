FROM quay.io/keycloak/keycloak:22.0.3
# Must add json files before import, volume is not mounted yet
ADD ./realms /opt/keycloak/data/import/
# Import all files
RUN /opt/keycloak/bin/kc.sh import --dir=/opt/keycloak/data/import/ --override true; exit 0
# Start image
ENTRYPOINT ["/opt/keycloak/bin/kc.sh", "-v", "start-dev"]