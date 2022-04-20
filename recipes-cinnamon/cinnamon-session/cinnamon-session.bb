SUMMARY = "A collection of configuration plugins used in cinnamon-settings"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = " \
    xmlto-native \
    gtk+3 \
    libcanberra \
    pango \
    libsm \
    libice \
    virtual/libx11 \
    libxau \
    libxcomposite \
    libxapp \
    virtual/libgl \
"

inherit meson pkgconfig features_check gtk-icon-cache gsettings

REQUIRED_DISTRO_FEATURES += "x11 opengl"

SRC_URI = "git://github.com/linuxmint/cinnamon-session.git;branch=master;protocol=https"
SRCREV = "956aa57b4b0401c3d136814a32d24a98066a9b9e"
PV = "5.2.0"
S = "${WORKDIR}/git"

EXTRA_OEMESON += " \
    -Dgconf=false \
"

#FILES:${PN} += "${libdir}/cinnamon-control-center-1/panels"
