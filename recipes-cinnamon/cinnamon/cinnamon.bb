SUMMARY = "A Linux desktop featuring a traditional layout"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=0159e10ccad3751f827b6741af79417b \
"

DEPENDS = " \
    libxml2-native \
    intltool-native \
    cjs \
    muffin \
    cinnamon-menus \
    polkit \
    libsoup-2.4 \
    libnma \
    startup-notification \
    gstreamer1.0-plugins-base \
    libxapp \
"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"
GIR_MESON_OPTION = ""

REQUIRED_DISTRO_FEATURES += "x11 polkit"

inherit meson pkgconfig gobject-introspection gtk-icon-cache gsettings gtk-doc gettext features_check

SRC_URI = "git://github.com/linuxmint/cinnamon.git;branch=master;protocol=https"
SRCREV = "037b17248b176c7f3dd5c9848f8c6738105c4cc2"
PV = "5.2.7+git${SRCPV}"
S = "${WORKDIR}/git"

FILES:${PN} += " \
    ${datadir}/cinnamon-session \
    ${datadir}/dbus-1 \
    ${datadir}/desktop-directories \
    ${datadir}/polkit-1 \
    ${datadir}/xsessions \
"

RDEPENDS:${PN} += " \
    bash \
    network-manager-applet \
    cinnamon-control-center \
    cinnamon-menus \
    cinnamon-screensaver \
    cinnamon-settings-daemon \
    nemo \
    evolution-data-server \
    libtimezonemap \
    tzdata \
    gettext \
    keybinder \
    python3-core \
    python3-distro \
    python3-dbus \
    python3-lxml \
    python3-pam \
    python3-pillow \
    python3-pexpect \
    python3-psutil \
    python3-pycairo \
    python3-pygobject \
    python3-pyinotify \
    python3-pytz \
    python3-requests \
    python3-setproctitle \
    python3-simplejson \
    python3-syslog \
    python3-tinycss2 \
    python3-xapp \
"

PACKAGES += "${PN}-python"
FILES:${PN}-python += "${PYTHON_SITEPACKAGES_DIR}"
